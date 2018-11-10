#!/bin/bash

for i in 1 2 3 4
do
	echo "\n\n\n\n\nInteração $i"
	for pasta in /home/tiago/Repositorios/Github/mdplib_2010/teste/*
	do
		if [ -d "$pasta" ]
		then
			cd $pasta
			echo "\n\nEntrou na pasta $pasta"
			for arquivo in $pasta/*
			do
				if [ -f "$arquivo" ]
				then
					#echo $arquivo
					java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Projeto/MaximumDiversityProblem/dist/MaximumDiversityProblem.jar" 1 1 1 $arquivo --nr 307 --const gp --p 0.13 --search fis
				fi
			done
		fi
	done
done

