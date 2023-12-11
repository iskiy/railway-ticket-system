package main

import (
	"database/sql"
	"fmt"
	"log"
	"os"
	"time"

	"github.com/gofiber/fiber/v2"
	"github.com/iskiy/railway-ticket-system/train-service/internal/delivery/rest"
	"github.com/iskiy/railway-ticket-system/train-service/internal/psql/sqlc"
	_ "github.com/lib/pq"
)

func main() {
	app := fiber.New(
		fiber.Config{
			IdleTimeout:  30 * time.Second,
			ReadTimeout:  30 * time.Second,
			WriteTimeout: 30 * time.Second,
		})

	connStr := "postgresql://root:password@localhost:5433/traindb?sslmode=disable"
	if os.Getenv("POSTGRES_CONN") != "" {
		connStr = os.Getenv("POSTGRES_CONN")
		fmt.Println(connStr)
	}

	conn, err := connToDB(connStr)
	if err != nil {
		log.Fatalln(err)
	}

	trainManager := rest.New(sqlc.New(conn))

	// Stations
	app.Post("/stations", trainManager.CreateStation)
	app.Get("/stations/:id", trainManager.GetStation)
	app.Get("/stations", trainManager.GetStations)
	app.Delete("stations:/id", trainManager.DeleteStation)

	// Trains
	app.Post("/trains", trainManager.CreateTrain)
	app.Get("trains", trainManager.GetTrains)
	app.Get("/trains-search", trainManager.GetTrainsWithAvailableSeats)
	app.Delete("/trains", trainManager.DeleteTrain)

	// Cars
	app.Post("/cars", trainManager.CreateCar)
	app.Get("/trains/:id/cars", trainManager.GetTrainCars)
	app.Get("/cars/:id", trainManager.GetCar)

	port := "8081"
	if os.Getenv("PORT") != "" {
		port = os.Getenv("PORT")
		fmt.Println(os.Getenv("PORT"))
	}

	err = app.Listen(":" + port)
	if err != nil {
		panic(err)
	}
}

func connToDB(connStr string) (*sql.DB, error) {
	var conn *sql.DB
	var err error

	for i := 0; i < 5; i++ {
		conn, err = sql.Open("postgres", connStr)
		if err != nil {
			log.Printf("Failed to open database connection: %v", err)
			fmt.Printf("Retrying to connect (%d/5)...\n", i+1)
			time.Sleep(10 * time.Second)
			continue
		}

		err = conn.Ping()
		if err != nil {
			log.Printf("Failed to ping database: %v", err)
			fmt.Printf("Retrying to connect (%d/5)...\n", i+1)
			time.Sleep(10 * time.Second)
			continue
		}
		break
	}

	if err != nil {
		log.Fatalf("After 5 attempts, failed to connect to database: %v", err)
		return nil, err
	}

	fmt.Println("Successfully connected to database")
	return conn, nil
}
