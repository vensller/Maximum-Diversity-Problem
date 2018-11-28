
java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/LeitorDados/dist/LeitorDados.jar" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/GKD-c/" 20 "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/mdplib_2010_bestvalues.csv" "gkd_c"

cp "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/GKD-c/tabela_gkd_c.tex" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Artigo_Latex/MDP/tabelas"

echo "1-Ok"

java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/LeitorDados/dist/LeitorDados.jar" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-a/" 20 "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/mdplib_2010_bestvalues.csv" "mdg_a"

cp "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-a/tabela_mdg_a.tex" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Artigo_Latex/MDP/tabelas"

echo "2-Ok"

java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/LeitorDados/dist/LeitorDados.jar" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-b/" 20 "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/mdplib_2010_bestvalues.csv" "mdg_b"

cp "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-b/tabela_mdg_b.tex" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Artigo_Latex/MDP/tabelas"

echo "3-Ok"

java -jar "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/LeitorDados/dist/LeitorDados.jar" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/SOM-b/" 20 "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/mdplib_2010_bestvalues.csv" "som_b"

cp "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Resultados/SOM-b/tabela_som_b.tex" "/home/tiago/Repositorios/Github/Maximum-Diversity-Problem/Artigo_Latex/MDP/tabelas"

echo "4-Ok"

