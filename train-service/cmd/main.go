package cmd

import (
	_ "github.com/jackc/pgx/v5"
)

func main() {
	//app := fiber.New(
	//	fiber.Config{
	//		IdleTimeout:  30 * time.Second,
	//		ReadTimeout:  30 * time.Second,
	//		WriteTimeout: 30 * time.Second,
	//	})
	//
	//conn, err := pgx.Connect(context.Background(), "postgresql://root:password@localhost:5433/traindb?sslmode=disable")
	//if err != nil {
	//	log.Fatal(err)
	//}
	//
	//sqlc.New(conn)
}
