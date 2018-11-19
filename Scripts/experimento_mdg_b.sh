#!/bin/bash

cd /home/usuario/Downloads/mdplib_2010/MDG_b/

for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
do
	echo "Interação $i:"
	for arquivo in /home/usuario/Downloads/mdplib_2010/MDG_b/*
		do
			if [ -f "$arquivo" ]
			then
				echo "$i-$arquivo"
				java -jar "/home/usuario/Repositorios/Github/Maximum-Diversity-Problem/Projeto/MaximumDiversityProblem/dist/MaximumDiversityProblem.jar" 1 1 1 $arquivo --nr 350 --const gp --p 0.13 --search fis
			fi
		done
done

