@echo off

PUSHD %1

cd client/

echo "Installing maven dependencies..."
mvn clean install

POPD
