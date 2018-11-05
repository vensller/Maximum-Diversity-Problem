#!/bin/bash

for i in {0..20};
do
	for pasta in /home/usuario/Repositorios/Github/mdplib_2010/*
	do
		if [ -d "$pasta" ]
		then
			cd $pasta
			echo "Entrou na pasta $pasta"
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

