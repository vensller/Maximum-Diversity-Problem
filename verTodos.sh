#!/bin/bash

for pasta in /home/usuario/Repositorios/Github/mdplib_2010/*
do
	if [ -d "$pasta" ]
	then
		cd $pasta
		echo "Entrou na pasta $pasta"
		for arquivo in ./*
		do
			if [ -f "$arquivo" ]
			then 
				echo "Arquivo: $arquivo"
			fi
		done
	fi
done
