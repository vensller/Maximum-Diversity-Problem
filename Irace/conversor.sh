#!/bin/bash

cp "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Projeto/MaximumDiversityProblem/dist/MaximumDiversityProblem.jar" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Irace"

cat stub.sh MaximumDiversityProblem.jar > target-runner && chmod +x target-runner
