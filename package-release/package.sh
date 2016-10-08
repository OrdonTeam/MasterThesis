#!/bin/bash
./gradlew jar
cd package-release
mkdir MasterThesis
mv ../build/libs/MasterThesis.jar MasterThesis/
cp README.txt MasterThesis/
cp RUN_example.bat MasterThesis/
cp RUN_sas1of12.bat MasterThesis/
cp ../src/test/resources/example_function.pla MasterThesis/
cp ../src/test/resources/sas1of12.pla MasterThesis/
zip MasterThesis.zip MasterThesis/*
rm -r MasterThesis
