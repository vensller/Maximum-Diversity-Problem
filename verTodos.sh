#!/bin/bash

for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
do
	echo "\n\n\n\n\nInteração $i"
	for pasta in /home/usuario/Repositorios/Github/mdplib_2010/*
	do
		if [ -d "$pasta" ]
		then
			cd $pasta
			echo "\n\nEntrou na pasta $pasta"
			for arquivo in $pasta/*
			do
				if [ -f "$arquivo" ]
				then
					#caminho="$arquivo"
					#echo $caminho
					java -jar "/home/usuario/Repositorios/Github/Maximum-Diversity-Problem/Projeto/MaximumDiversityProblem/dist/MaximumDiversityProblem.jar" 1 1 1 $arquivo --nr 307 --const gp --p 0.13 --search fis
				fi
			done
		fi
	done
done

