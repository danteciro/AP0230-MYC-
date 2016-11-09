/* 1) -------------------------------- NPS_ETAPA-------------------*/

CREATE TABLE NPS_ETAPA
(
  ID_ETAPA             NUMBER(10) NOT NULL ,
  ID_PROCESO           NUMBER(10) NULL ,
  DESCRIPCION          VARCHAR2(100) NULL ,
  ESTADO               CHAR(1) NOT NULL ,
  PLAZO                NUMBER(2) NULL ,
  USUARIO_CREACION     VARCHAR2(38) NOT NULL ,
  FECHA_CREACION       DATE NOT NULL ,
  TERMINAL_CREACION    VARCHAR(38) NULL ,
  USUARIO_ACTUALIZACION VARCHAR2(38) NULL ,
  FECHA_ACTUALIZACION  DATE NULL ,
  TERMINAL_ACTUALIZACION VARCHAR(38) NULL 
);
-- COMENTARIOS DE LAS COLUMNAS
COMMENT ON COLUMN NPS_ETAPA.ID_ETAPA IS 'Identificador etapa';
COMMENT ON COLUMN NPS_ETAPA.ID_PROCESO IS 'Identificador del Proceso.';
COMMENT ON COLUMN NPS_ETAPA.DESCRIPCION IS 'Descripci�n de la etapa';
COMMENT ON COLUMN NPS_ETAPA.USUARIO_CREACION IS 'Usuario creador del registro.';
COMMENT ON COLUMN NPS_ETAPA.FECHA_CREACION IS 'Fecha en la que se cre� el registro (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_ETAPA.TERMINAL_CREACION IS 'Terminal de creaci�n.';
COMMENT ON COLUMN NPS_ETAPA.USUARIO_ACTUALIZACION IS 'Usuario que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_ETAPA.FECHA_ACTUALIZACION IS 'Fecha en la que se modific� el registro por �ltima vez (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_ETAPA.TERMINAL_ACTUALIZACION IS 'Terminal que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_ETAPA.PLAZO IS 'Plazo de atenci�n de la Etapa';
COMMENT ON COLUMN NPS_ETAPA.ESTADO IS 'Indica si el registro est� vigente.
0: El registro ya no se encuentra vigente.
1: El registro est� vigente.';
COMMENT ON TABLE NPS_ETAPA IS 'Tabla que almacena las etapas por las que pasar� los tramites generados por los inversionistas';

-- INDICE 
CREATE UNIQUE INDEX NPS_ETAPA_ID_ETA_IDX ON NPS_ETAPA
(ID_ETAPA   ASC);

ALTER TABLE NPS_ETAPA
ADD CONSTRAINT  NPS_ETAPA_PK PRIMARY KEY (ID_ETAPA);

ALTER TABLE NPS_ETAPA
ADD (CONSTRAINT NPS_PROCESO_FK FOREIGN KEY (ID_PROCESO) REFERENCES PGH_PROCESO (ID_PROCESO) ON DELETE SET NULL);

/* 2) -------------------------- NPS_TRAMITE ---------------------------*/

CREATE TABLE NPS_TRAMITE
(
	ID_TRAMITE           NUMBER(10) NOT NULL ,
	DESCRIPCION          VARCHAR2(100) NULL ,
	ESTADO               CHAR(1) NOT NULL ,
	USUARIO_CREACION     VARCHAR2(38) NOT NULL ,
	FECHA_CREACION       DATE NOT NULL ,
	TERMINAL_CREACION    VARCHAR(38) NOT NULL ,
	USUARIO_ACTUALIZACION VARCHAR2(38) NULL ,
	FECHA_ACTUALIZACION  DATE NULL ,
	TERMINAL_ACTUALIZACION VARCHAR2(38) NULL 
);

-- COMENTARIOS DE LAS COLUMNAS
COMMENT ON COLUMN NPS_TRAMITE.ID_TRAMITE IS 'Identificador del tramite';
COMMENT ON COLUMN NPS_TRAMITE.DESCRIPCION IS 'Descripci�n del Tr�mite';
COMMENT ON COLUMN NPS_TRAMITE.USUARIO_CREACION IS 'Usuario creador del registro.';
COMMENT ON COLUMN NPS_TRAMITE.FECHA_CREACION IS 'Fecha en la que se cre� el registro (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_TRAMITE.TERMINAL_CREACION IS 'Terminal de creaci�n.';
COMMENT ON COLUMN NPS_TRAMITE.USUARIO_ACTUALIZACION IS 'Usuario que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_TRAMITE.FECHA_ACTUALIZACION IS 'Fecha en la que se modific� el registro por �ltima vez (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_TRAMITE.TERMINAL_ACTUALIZACION IS 'Terminal que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_TRAMITE.ESTADO IS 'Indica si el registro est� vigente.
0: El registro ya no se encuentra vigente.
1: El registro est� vigente.';
COMMENT ON TABLE NPS_TRAMITE IS 'Tabla que almacena los tramites que podra realizar el inversionista';
  
--- INDICE
CREATE UNIQUE INDEX NPS_TRAMITE_ID_TRA_IDX ON NPS_TRAMITE
(ID_TRAMITE   ASC);

-- PRIMARY KEY
ALTER TABLE NPS_TRAMITE
	ADD CONSTRAINT  NPS_TRAMITE_PK PRIMARY KEY (ID_TRAMITE);

/* 3) -------------------------------- NPS_CONF_TRAMITE-------------------*/
CREATE TABLE NPS_CONF_TRAMITE
(
  ID_CONF_TRAMITE      NUMBER(10) NOT NULL ,
  ID_CNF_ACT_UNI_ORGANICA NUMBER(10) NULL ,
  ID_TRAMITE           NUMBER(10) NULL ,
  ESTADO               CHAR(1) NOT NULL ,
  ORIENTACION          VARCHAR2(200) NULL ,
  PORCENTAJE_NOTIFICACION NUMBER(3) NULL ,
  USUARIO_CREACION     VARCHAR2(38) NOT NULL ,
  FECHA_CREACION       DATE NOT NULL ,
  TERMINAL_CREACION    VARCHAR(38) NOT NULL ,
  USUARIO_ACTUALIZACION VARCHAR2(38) NULL ,
  FECHA_ACTUALIZACION DATE NULL ,
  TERMINAL_ACTUALIZACION VARCHAR(38) NULL 
);

-- COMENTARIOS DE LAS COLUMNAS
COMMENT ON COLUMN NPS_CONF_TRAMITE.ID_CONF_TRAMITE IS 'Configuracion del Tramite';
COMMENT ON COLUMN NPS_CONF_TRAMITE.ID_CNF_ACT_UNI_ORGANICA IS 'Identificador del registro';
COMMENT ON COLUMN NPS_CONF_TRAMITE.ESTADO IS 'Indica si el registro se encuentra vigente: 1, no se encuentra vigente: 0.';
COMMENT ON COLUMN NPS_CONF_TRAMITE.USUARIO_CREACION IS 'Usuario creador del registro';
COMMENT ON COLUMN NPS_CONF_TRAMITE.FECHA_CREACION IS 'Fecha en la que se cre� el registro (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_CONF_TRAMITE.TERMINAL_CREACION IS 'Terminal de creaci�n.';
COMMENT ON COLUMN NPS_CONF_TRAMITE.USUARIO_ACTUALIZACION IS 'Usuario que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_CONF_TRAMITE.FECHA_ACTUALIZACION IS 'Fecha en la que se modific� el registro por �ltima vez (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_CONF_TRAMITE.TERMINAL_ACTUALIZACION IS 'Terminal que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_CONF_TRAMITE.ID_TRAMITE IS 'Identificador del tramite';
COMMENT ON COLUMN NPS_CONF_TRAMITE.ORIENTACION IS 'Informaci�n de Orientaci�n relacionada al tr�mite';
COMMENT ON COLUMN NPS_CONF_TRAMITE.PORCENTAJE_NOTIFICACION IS 'Porcentaje de Notificaciones efectuadas';

COMMENT ON TABLE NPS_CONF_TRAMITE IS 'Tabla que almacena las configuraciones entre los tramites y las configuraciones de las unidades organicas por actividad ';
-- INDICE 
CREATE UNIQUE INDEX NPS_CONF_TRAMITE_ID_CONF_IDX ON NPS_CONF_TRAMITE
(ID_CONF_TRAMITE   ASC);

ALTER TABLE NPS_CONF_TRAMITE
ADD CONSTRAINT  NPS_CONF_TRAMITE_PK PRIMARY KEY (ID_CONF_TRAMITE);

ALTER TABLE NPS_CONF_TRAMITE
	ADD (CONSTRAINT PGH_CNF_ACT_UNI_ORGANICA_FK FOREIGN KEY (ID_CNF_ACT_UNI_ORGANICA) REFERENCES PGH_CNF_ACT_UNI_ORGANICA (ID_CNF_ACT_UNI_ORGANICA) ON DELETE SET NULL);

ALTER TABLE NPS_CONF_TRAMITE
	ADD (CONSTRAINT NPS_TRAMITE_FK FOREIGN KEY (ID_TRAMITE) REFERENCES NPS_TRAMITE (ID_TRAMITE) ON DELETE SET NULL);

/* 4) -------------------------------- NPS_ETAPA_TRAMITE-------------------*/

CREATE TABLE NPS_ETAPA_TRAMITE
(
	ID_ETAPA_TRAMITE     NUMBER(10) NOT NULL ,
	ID_ETAPA             NUMBER(10) NULL ,
	ID_CONF_TRAMITE      NUMBER(10) NULL ,
	ESTADO               CHAR(1) NOT NULL ,
	USUARIO_CREACION     VARCHAR2(38) NOT NULL ,
	FECHA_CREACION       DATE NOT NULL ,
	TERMINAL_CREACION    VARCHAR(38) NOT NULL ,
	USUARIO_ACTUALIZACION VARCHAR2(38) NULL ,
	FECHA_ACTUALIZACION  DATE NULL ,
	TERMINAL_ACTUALIZACION VARCHAR(38) NULL 
);

-- COMENTARIOS DE LAS COLUMNAS
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.ID_ETAPA_TRAMITE IS 'Identificador de Etapa y Tramite';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.ID_ETAPA IS 'Identificador etapa';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.USUARIO_CREACION IS 'Usuario creador del registro.';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.FECHA_CREACION IS 'Fecha en la que se cre� el registro (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.TERMINAL_CREACION IS 'Terminal de creaci�n.';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.USUARIO_ACTUALIZACION IS 'Usuario que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.FECHA_ACTUALIZACION IS 'Fecha en la que se modific� el registro por �ltima vez (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.TERMINAL_ACTUALIZACION IS 'Terminal que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.ID_CONF_TRAMITE IS 'Identificador de configuracion del Tramite';
COMMENT ON COLUMN NPS_ETAPA_TRAMITE.ESTADO IS 'Indica si el registro se encuentra vigente: 1, no se encuentra vigente: 0.';
COMMENT ON TABLE NPS_ETAPA_TRAMITE IS 'Tabla que almacena las configuraciones entre las etapas y los tramites configurados';

-- INDICE 
CREATE UNIQUE INDEX NPS_ETAPA_TRA_ID_ETA_IDX ON NPS_ETAPA_TRAMITE
(ID_ETAPA_TRAMITE   ASC);

ALTER TABLE NPS_ETAPA_TRAMITE
	ADD CONSTRAINT  NPS_ETAPA_TRAMITE_PK PRIMARY KEY (ID_ETAPA_TRAMITE);
ALTER TABLE NPS_ETAPA_TRAMITE
	ADD (CONSTRAINT NPS_ETAPA_FK FOREIGN KEY (ID_ETAPA) REFERENCES NPS_ETAPA (ID_ETAPA));
ALTER TABLE NPS_ETAPA_TRAMITE
	ADD (CONSTRAINT NPS_CONF_TRAMITE_FK FOREIGN KEY (ID_CONF_TRAMITE) REFERENCES NPS_CONF_TRAMITE (ID_CONF_TRAMITE) ON DELETE SET NULL);



/* 5) -------------------------- NPS_SUBETAPA ---------------------------*/

CREATE TABLE NPS_SUBETAPA
(
  ID_SUBETAPA          NUMBER(10) NOT NULL ,
  ID_ETAPA             NUMBER(10) NULL ,
  DESCRIPCION          VARCHAR2(100) NULL ,
  ESTADO               CHAR(1) NOT NULL ,
  TIEMPO_DIAS          NUMBER(2) NULL ,
  ID_RESPONSABLE       NUMBER(10) NULL ,
  USUARIO_CREACION     VARCHAR2(38) NOT NULL ,
  FECHA_CREACION       DATE NOT NULL ,
  TERMINAL_CREACION    VARCHAR(38) NULL ,
  USUARIO_ACTUALIZACION VARCHAR2(38) NULL ,
  FECHA_ACTUALIZACION  DATE NULL ,
  TERMINAL_ACTUALIZACION VARCHAR(38) NULL 
);

-- COMENTARIOS DE LAS COLUMNAS
COMMENT ON COLUMN NPS_SUBETAPA.ID_SUBETAPA IS 'Identificador de la SubEtapa de atenci�n';
COMMENT ON COLUMN NPS_SUBETAPA.DESCRIPCION IS 'Descripci�n de la SubEtapa de atenci�n';
COMMENT ON COLUMN NPS_SUBETAPA.TIEMPO_DIAS IS 'Tiempo de d�as h�biles para la atenci�n';
COMMENT ON COLUMN NPS_SUBETAPA.ID_RESPONSABLE IS 'Responsable de la atenci�n';
COMMENT ON COLUMN NPS_SUBETAPA.USUARIO_CREACION IS 'Usuario creador del registro.';
COMMENT ON COLUMN NPS_SUBETAPA.FECHA_CREACION IS 'Fecha en la que se cre� el registro (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_SUBETAPA.TERMINAL_CREACION IS 'Terminal de creaci�n.';
COMMENT ON COLUMN NPS_SUBETAPA.USUARIO_ACTUALIZACION IS 'Usuario que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_SUBETAPA.FECHA_ACTUALIZACION IS 'Fecha en la que se modific� el registro por �ltima vez (Formato: DD/MM/YYYY hh:mm:ss).';
COMMENT ON COLUMN NPS_SUBETAPA.TERMINAL_ACTUALIZACION IS 'Terminal que modific� el registro por �ltima vez.';
COMMENT ON COLUMN NPS_SUBETAPA.ID_ETAPA IS 'Identificador etapa';
COMMENT ON COLUMN NPS_SUBETAPA.ESTADO IS 'Indica si el registro est� vigente.
0: El registro ya no se encuentra vigente.
1: El registro est� vigente.';
COMMENT ON TABLE NPS_SUBETAPA IS 'Tabla que almacena las subetapas';

--- INDICE
CREATE UNIQUE INDEX NPS_SUBETAPA_ID_SUB_ETA_IDX ON NPS_SUBETAPA
(ID_SUBETAPA   ASC);

-- PRIMARY KEY
ALTER TABLE NPS_SUBETAPA
ADD CONSTRAINT  NPS_SUBETAPA_PK PRIMARY KEY (ID_SUBETAPA);

ALTER TABLE NPS_SUBETAPA
	ADD (CONSTRAINT NPS_ETAPA_SUB_FK FOREIGN KEY (ID_ETAPA) REFERENCES NPS_ETAPA (ID_ETAPA) ON DELETE SET NULL);
	

--------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------- SEQUENCES -------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------------
  create sequence NPS_ETAPA_SEQ
  minvalue 1
  maxvalue 9999999999999999999999999999
  start with 1
  increment by 1
  nocache;
  
  create sequence NPS_CONF_TRAMITE_SEQ
  minvalue 1
  maxvalue 9999999999999999999999999999
  start with 1
  increment by 1
  nocache;
  
  create sequence NPS_TRAMITE_SEQ
  minvalue 1
  maxvalue 9999999999999999999999999999
  start with 1
  increment by 1
  nocache;
  
  create sequence NPS_ETAPA_TRAMITE_SEQ
  minvalue 1
  maxvalue 9999999999999999999999999999
  start with 1
  increment by 1
  nocache;
  
  create sequence NPS_SUBETAPA_SEQ
  minvalue 1
  maxvalue 9999999999999999999999999999
  start with 1
  increment by 1
  nocache;




