data <- read.csv("merged.csv")

idade_media <- mean(data$Idade.)

#count por genero
aggregate(data.frame(count = data$Gênero.), list(value = data$Gênero.), length)

