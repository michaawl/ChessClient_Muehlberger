@echo off

PUSHD %1

cd server/

del ChessDatabase.*
del /q Migrations

echo "Installing dotnet dependencies..."
dotnet add package microsoft.entityFrameworkCore.design
dotnet add package microsoft.entityFrameworkCore.sqlite
dotnet add package grpc.tools
dotnet add package Grpc.AspNetCore
dotnet add package Microsoft.EntityFrameworkCore.Tools

echo "Configuring and create database..."
dotnet tool install --global dotnet-ef
dotnet ef migrations add InitialMigration

dotnet ef database update

POPD
