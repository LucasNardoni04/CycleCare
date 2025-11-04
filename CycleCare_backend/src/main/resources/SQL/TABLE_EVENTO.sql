CREATE TABLE eventos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    descricao TEXT,
    data_hora_inicio DATE,
    data_hora_fim DATE,
    ciclo_id BIGINT NOT NULL,
    CONSTRAINT fk_eventos_ciclo
        FOREIGN KEY (ciclo_id)
        REFERENCES ciclos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
