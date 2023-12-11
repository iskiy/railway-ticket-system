# Create new migration
# Example make new_migration name=init
new_migration:
	migrate create -ext sql -dir migration -seq $(name)

migrate_up:
	migrate -path migrations -database "postgresql://root:password@localhost:5436/bookingdb?sslmode=disable" -verbose up

migrate_down:
	migrate -path migrations -database "postgresql://root:password@localhost:5436/bookingdb?sslmode=disable" -verbose down

