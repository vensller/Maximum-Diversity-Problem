# dados <- read_excel("Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-a/mdg_a_3.xlsx")
# titulo <- "Melhora da qualidade da resposta em \nfunção do tempo da instância MDG-a 3"
library(readxl)

# dados <- read_excel("Repositorios/Github/Maximum-Diversity-Problem/Resultados/dados1.xlsx")
# titulo <- "Melhora da qualidade da resposta em \nfunção do tempo em MDG-a"
# legenda <- c("MDG-a 10", "MDG-a 9", "MDG-a 14", "MDG-a 1", "MDG-a 18")

dados <- read_excel("Repositorios/Github/Maximum-Diversity-Problem/Resultados/dados2.xlsx")
titulo <- "Melhora da qualidade da resposta em \nfunção do tempo em SOM-b"
legenda <- c("SOM-b 10", "SOM-b 13", "SOM-b 20", "SOM-b 14", "SOM-b 11")

x <- "Tempo (ms)"
y <- "Resposta"

plot( 
  dados$t1, dados$p1,
  type="l", pch=2, col="black", 
  xlab=x, ylab=y, main=titulo,
  ylim=c(0, 1))

# Add a line
lines(dados$t2, dados$p2, col="red")
lines(dados$t3, dados$p3, col="blue")
lines(dados$t4, dados$p4, col="green")
lines(dados$t5, dados$p5, col="yellow")

legend(
  "bottomright",
  inset=.1,
  legend=legenda,
  col=c("red", "blue", "green", "yellow")
  , lty=1
  , cex=0.8
)

