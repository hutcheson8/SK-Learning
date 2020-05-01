dir /s /B *.java > out\sources.txt
javac -sourcepath src -d bin @out\sources.txt
cmd /k C:\Users\Knives\venv\Scripts\activate
