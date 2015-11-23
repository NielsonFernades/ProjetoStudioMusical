/* SQLINES EVALUATION VERSION TRUNCATES VARIABLE NAMES AND COMMENTS. */
/* OBTAIN A LICENSE AT WWW.SQLINES.COM FOR FULL CONVERSION. THANK YOU. */

/* LIMPANDO A TABELA
ALTER TABLE endereco
DISABLE CONSTRAINT fk_cliente;

truncate table endereco;
truncate table cliente;

ALTER TABLE endereco
ENABLE CONSTRAINT fk_cliente;

begin 
  reset_seq('cliente_seq'); 
  reset_seq('endereco_seq'); 
end;
*/

CREATE TABLE cliente (
  cliente_id NUMBER(10) NOT NULL,
  nome VARCHAR2(50) NOT NULL,
  cpf VARCHAR2(11) NOT NULL,
  banco VARCHAR2(50) NOT NULL,
  PRIMARY KEY (cliente_id),
  CONSTRAINT cpf UNIQUE  (cpf)
)
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE cliente_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER cliente_seq_tr
 BEFORE INSERT ON cliente FOR EACH ROW
 WHEN (NEW.cliente_id IS NULL)
BEGIN
 SELECT cliente_seq.NEXTVAL INTO :NEW.cliente_id FROM DUAL;
END;
/

CREATE TABLE endereco (
  endereco_id NUMBER(10) NOT NULL,
  cliente_id NUMBER(10) DEFAULT '0' NOT NULL,
  rua VARCHAR2(50) DEFAULT '0' NOT NULL,
  numero VARCHAR2(50) DEFAULT '0' NOT NULL,
  complemento VARCHAR2(50) DEFAULT '0' NOT NULL,
  bairro VARCHAR2(50) DEFAULT '0' NOT NULL,
  cidade VARCHAR2(50) DEFAULT '0' NOT NULL,
  cep VARCHAR2(50) DEFAULT '0' NOT NULL,
  PRIMARY KEY (endereco_id)
 ,
  CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id)
)
;

-- Generate ID using sequence and trigger
CREATE SEQUENCE endereco_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER endereco_seq_tr
 BEFORE INSERT ON endereco FOR EACH ROW
 WHEN (NEW.endereco_id IS NULL)
BEGIN
 SELECT endereco_seq.NEXTVAL INTO :NEW.endereco_id FROM DUAL;
END;
/

CREATE INDEX fk_cliente ON endereco (cliente_id);
/

create or replace
procedure reset_seq( p_seq_name in varchar2 )
is
    l_val number;
begin
    execute immediate
    'select ' || p_seq_name || '.nextval from dual' INTO l_val;

    execute immediate
    'alter sequence ' || p_seq_name || ' increment by -' || l_val || 
                                                          ' minvalue 0';

    execute immediate
    'select ' || p_seq_name || '.nextval from dual' INTO l_val;

    execute immediate
    'alter sequence ' || p_seq_name || ' increment by 1 minvalue 0';
end;
/
