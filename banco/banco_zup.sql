CREATE TABLE `projetozup`.`usuario`(
    `id_usuario` int not null,
    `cpf` varchar(14) not null,
    `nm_usuario` varchar(100) null,
    `email` varchar(150) not null,
    `dt_nasc` date null,
    constraint pk_id_usuario primary key (id_usuario),
    constraint uk_cpf_usuario unique(cpf),
    constraint uk_email unique(email)
);

ALTER TABLE `projetozup`.`usuario`
CHANGE COLUMN `id_usuario` `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_usuario` (`id_usuario` ASC); 

create table `projetozup`.`endereco`(
    `id_endereco` int not null,
    `id_usuario` int not null,
    `cep` varchar(9) not null,
    `logradouro` varchar(300) null,
    `numero` int null,
    `complemento` varchar(100) null,
    `bairro` varchar(100) null,
    `cidade` varchar(100) null,
    `uf` varchar(2) null,
    constraint pk_id_endereco primary key(id_endereco),
    constraint fk_endereco_usuario foreign key(id_usuario) references usuario(id_usuario)
);

ALTER TABLE `projetozup`.`endereco`
CHANGE COLUMN `id_endereco` `id_endereco` INT(11) NOT NULL AUTO_INCREMENT,
ADD UNIQUE INDEX `id_endereco` (`id_endereco` ASC); 

