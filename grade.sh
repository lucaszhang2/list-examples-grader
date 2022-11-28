# Create your grading script here

set -e

rm -rf student-submission
git clone $1 student-submission

if[[ -f student-submission/ListExamples.java]]
then
    cp TestListExamples.java student-submission
    cp -r lib student-submission
    cp Server.java student-submission
    cp GradeServer.java student-submission
else
    echo "ListExamples.java does not found. Check your submission. "
    echo "Your score is 0. "
    exit 1
fi

cd student-submission

set +e
javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java

if[[$? == 0]]
then
    java -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples
    if[[$? == 0]]
        echo "Your score is 1. "
        exit 1
    else
        echo "Your score is 0. Test not pass! "
        exit 1
    fi
else
    echo "compiling error! "
    echo "You score is 0. "
    exit 1
fi