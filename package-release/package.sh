#!/bin/bash
./gradlew jar
cd package-release
mkdir MasterThesis
perl -pe 's/\r\n|\n|\r/\r\n/g' README.txt > MasterThesis/README.txt
perl -pe 's/\r\n|\n|\r/\r\n/g' RUN_example.bat > MasterThesis/RUN_example.bat
perl -pe 's/\r\n|\n|\r/\r\n/g' RUN_sas1of12.bat > MasterThesis/RUN_sas1of12.bat
perl -pe 's/\r\n|\n|\r/\r\n/g' RUN_sas1of32.bat > MasterThesis/RUN_sas1of32.bat
perl -pe 's/\r\n|\n|\r/\r\n/g' ../src/test/resources/example_function.pla > MasterThesis/example_function.pla
perl -pe 's/\r\n|\n|\r/\r\n/g' ../src/test/resources/sas1of12.pla > MasterThesis/sas1of12.pla
perl -pe 's/\r\n|\n|\r/\r\n/g' ../src/test/resources/sas1of32.pla > MasterThesis/sas1of32.pla
mv ../build/libs/MasterThesis.jar MasterThesis/
zip MasterThesis.zip MasterThesis/*
rm -r MasterThesis
