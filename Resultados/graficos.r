# x<-1:10; y1=x*x; y2=2*y1
# 
# plot(x, y1, type="b", pch=19, col="red", xlab="x", ylab="y")
# 
# # Add a line
# lines(x, y2, type="b", pch=18, col="blue", lty=2)
# 
# legend(1, 95, legend=c("Line 1", "Line 2"),
#        col=c("red", "blue"), lty=1:2, cex=0.8)

dados <- read_excel("Repositorios/Github/Maximum-Diversity-Problem/Resultados/MDG-a/mdg_a_2.xlsx")
titulo <- "Melhora da quantidade em \nfunção do tempo da instância MDG-a 2"
x <- "Tempo (ms)"
y <- "Resposta"
plot(dados$t1, dados$s1, type="l", pch=2, col="black", xlab=x, ylab=y, main=titulo)

# Add a line
lines(dados$t2, dados$s2, type="l", pch=18, col="black", lty=2)
lines(dados$t3, dados$s3, type="l", pch=18, col="black", lty=2)
lines(dados$t4, dados$s4, type="l", pch=18, col="black", lty=2)
lines(dados$t5, dados$s5, type="l", pch=18, col="black", lty=2)
lines(dados$t6, dados$s6, type="l", pch=18, col="black", lty=2)
lines(dados$t7, dados$s7, type="l", pch=18, col="black", lty=2)
lines(dados$t8, dados$s8, type="l", pch=18, col="black", lty=2)
lines(dados$t9, dados$s9, type="l", pch=18, col="black", lty=2)
lines(dados$t10, dados$s10, type="l", pch=18, col="black", lty=2)
lines(dados$t11, dados$s11, type="l", pch=18, col="black", lty=2)
lines(dados$t12, dados$s12, type="l", pch=18, col="black", lty=2)
lines(dados$t13, dados$s13, type="l", pch=18, col="black", lty=2)
lines(dados$t14, dados$s14, type="l", pch=18, col="black", lty=2)
lines(dados$t15, dados$s15, type="l", pch=18, col="black", lty=2)
lines(dados$t16, dados$s16, type="l", pch=18, col="black", lty=2)
lines(dados$t17, dados$s17, type="l", pch=18, col="black", lty=2)
lines(dados$t18, dados$s18, type="l", pch=18, col="black", lty=2)
lines(dados$t19, dados$s19, type="l", pch=18, col="black", lty=2)
lines(dados$t20, dados$s20, type="l", pch=18, col="black", lty=2)

legend(1, 95, legend=c("Line 1", "Line 2"),
       col=c("red", "blue"), lty=1:2, cex=0.8)

