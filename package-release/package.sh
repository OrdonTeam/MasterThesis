#!/bin/bash
./gradlew jar
cd package-release
mkdir MasterThesis
mv ../build/libs/MasterThesis.jar MasterThesis/
cp README.bat MasterThesis/
cp example_function MasterThesis/
zip MasterThesis.zip MasterThesis/*
rm -r MasterThesis
