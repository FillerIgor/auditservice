### How to run local PostgreSQL with preinstalled Docker

docker run --name postgres -e POSTGRES_PASSWORD={password_placeholder} -d postgres -p 5432:5432

Then you could connect to the PostgreSQL with user: postgres and specified password via {password_placeholder}.