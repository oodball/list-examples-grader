# Create your grading script here
set -e
rm -rf student-submission
git clone $1 student-submission
cd student-submission

set -e
if [[ -e ListExamples.java ]]
then
    echo "file found"
else
    echo "file not found, check formatting or naming"
    exit 1
fi
cd .. 
set +e
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" *.java 2> stderr.txt

if [[ $? -ne 0 ]]
then
    echo "compiler error"
    cat stderr.txt 
    exit 1
else
    echo "successfully compiled"
fi

java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > output.txt
grep "Tests run:" < output.txt > results.txt
PASSED=`wc -l results.txt | grep -o '[0-9]'`
VARS=(`grep -Eo '[0-9]{1,2}' < results.txt`)

if [[ ${VARS[0]} -ne ${VARS[1]} ]]
then
    echo "error"
    echo "$((${VARS[0]}-${VARS[1]}))/7 tests passed."
else
    echo "All tests passed."
fi
cat output.txt



    