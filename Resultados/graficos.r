
sa <- table( Dados$MDGa_12_Solucao )
ta <- table( Dados$MDGa_12_Tempo )

i1 <- approx(sa, ta, method="linear")

grafico <- plot(ta, sa, type = "l", ylim=c(100000, 20000))
# grafico

x <- seq(0.5, 1.5, 0.25)
y <- rep(1, length(x))
plot(x, y, type="n")
points(x, y)
