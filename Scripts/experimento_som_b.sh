#!/bin/bash

for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
do
	echo "\n\n\n\n\nInteração $i"
	for arquivo in /home/usuario/Downloads/mdplib_2010/SOM_b/*
		do
			if [ -f "$arquivo" ]
			then
				echo $arquivo
				#java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Projeto/MaximumDiversityProblem/dist/MaximumDiversityProblem.jar" 1 1 1 $arquivo --nr 307 --const gp --p 0.13 --search fis
			fi
		done
done

