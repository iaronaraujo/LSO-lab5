library("ggplot2")

args = commandArgs(trailingOnly=TRUE)
#data = read.csv(args[2], header = TRUE)
data = read.csv("../Output4.plot", header = TRUE)

summary(data)

p <- ggplot(data, aes(x=buffer_size, y=moves, color=algorithm))
p <- p + geom_line()
ggsave(p, file=paste("resultado4", "png", sep="."))
