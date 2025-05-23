PGDMP      9                }            sist_consul_medico    16.3    17.4 3    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16436    sist_consul_medico    DATABASE     �   CREATE DATABASE sist_consul_medico WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
 "   DROP DATABASE sist_consul_medico;
                     postgres    false            �            1259    16456    consulta    TABLE       CREATE TABLE public.consulta (
    id_consulta bigint NOT NULL,
    fecha date NOT NULL,
    hora time without time zone NOT NULL,
    motivo_consulta text,
    diagnostico text,
    id_paciente bigint,
    id_medico bigint,
    hora_fin time without time zone
);
    DROP TABLE public.consulta;
       public         heap r       postgres    false            �            1259    16455    consulta_id_consulta_seq    SEQUENCE     �   CREATE SEQUENCE public.consulta_id_consulta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.consulta_id_consulta_seq;
       public               postgres    false    220            �           0    0    consulta_id_consulta_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.consulta_id_consulta_seq OWNED BY public.consulta.id_consulta;
          public               postgres    false    219            �            1259    16447    medico    TABLE     S  CREATE TABLE public.medico (
    id_medico bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    apellido character varying(255) NOT NULL,
    especialidad character varying(255) NOT NULL,
    numero_licencia character varying(255) NOT NULL,
    telefono character varying(255),
    correo_electronico character varying(255)
);
    DROP TABLE public.medico;
       public         heap r       postgres    false            �            1259    16446    medico_id_medico_seq    SEQUENCE     �   CREATE SEQUENCE public.medico_id_medico_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.medico_id_medico_seq;
       public               postgres    false    218            �           0    0    medico_id_medico_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.medico_id_medico_seq OWNED BY public.medico.id_medico;
          public               postgres    false    217            �            1259    16438    paciente    TABLE     E  CREATE TABLE public.paciente (
    id_paciente bigint NOT NULL,
    nombre character varying(255) NOT NULL,
    documento_identidad character varying(255) NOT NULL,
    fecha_nacimiento date NOT NULL,
    telefono character varying(255),
    correo_electronico character varying(255),
    direccion character varying(255)
);
    DROP TABLE public.paciente;
       public         heap r       postgres    false            �            1259    16437    paciente_id_paciente_seq    SEQUENCE     �   CREATE SEQUENCE public.paciente_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.paciente_id_paciente_seq;
       public               postgres    false    216            �           0    0    paciente_id_paciente_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.paciente_id_paciente_seq OWNED BY public.paciente.id_paciente;
          public               postgres    false    215            �            1259    16465    receta    TABLE     �   CREATE TABLE public.receta (
    id_receta bigint NOT NULL,
    medicamento character varying(255) NOT NULL,
    dosis character varying(50),
    instrucciones text,
    id_consulta bigint
);
    DROP TABLE public.receta;
       public         heap r       postgres    false            �            1259    16464    receta_id_receta_seq    SEQUENCE     �   CREATE SEQUENCE public.receta_id_receta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.receta_id_receta_seq;
       public               postgres    false    222            �           0    0    receta_id_receta_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.receta_id_receta_seq OWNED BY public.receta.id_receta;
          public               postgres    false    221            �            1259    16575    recetas    TABLE     �   CREATE TABLE public.recetas (
    id_receta bigint NOT NULL,
    medicamento character varying(255) NOT NULL,
    dosis character varying(50),
    instrucciones text,
    id_consulta bigint NOT NULL
);
    DROP TABLE public.recetas;
       public         heap r       postgres    false            �            1259    16574    recetas_id_receta_seq    SEQUENCE     �   ALTER TABLE public.recetas ALTER COLUMN id_receta ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.recetas_id_receta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    226            �            1259    16474    usuario    TABLE     �   CREATE TABLE public.usuario (
    id_usuario bigint NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(100) NOT NULL,
    rol character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap r       postgres    false            �            1259    16473    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public               postgres    false    224            �           0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public               postgres    false    223            5           2604    16537    consulta id_consulta    DEFAULT     |   ALTER TABLE ONLY public.consulta ALTER COLUMN id_consulta SET DEFAULT nextval('public.consulta_id_consulta_seq'::regclass);
 C   ALTER TABLE public.consulta ALTER COLUMN id_consulta DROP DEFAULT;
       public               postgres    false    219    220    220            4           2604    16520    medico id_medico    DEFAULT     t   ALTER TABLE ONLY public.medico ALTER COLUMN id_medico SET DEFAULT nextval('public.medico_id_medico_seq'::regclass);
 ?   ALTER TABLE public.medico ALTER COLUMN id_medico DROP DEFAULT;
       public               postgres    false    218    217    218            3           2604    16503    paciente id_paciente    DEFAULT     |   ALTER TABLE ONLY public.paciente ALTER COLUMN id_paciente SET DEFAULT nextval('public.paciente_id_paciente_seq'::regclass);
 C   ALTER TABLE public.paciente ALTER COLUMN id_paciente DROP DEFAULT;
       public               postgres    false    216    215    216            6           2604    16587    receta id_receta    DEFAULT     t   ALTER TABLE ONLY public.receta ALTER COLUMN id_receta SET DEFAULT nextval('public.receta_id_receta_seq'::regclass);
 ?   ALTER TABLE public.receta ALTER COLUMN id_receta DROP DEFAULT;
       public               postgres    false    222    221    222            7           2604    16607    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public               postgres    false    223    224    224            �          0    16456    consulta 
   TABLE DATA           |   COPY public.consulta (id_consulta, fecha, hora, motivo_consulta, diagnostico, id_paciente, id_medico, hora_fin) FROM stdin;
    public               postgres    false    220   .>       �          0    16447    medico 
   TABLE DATA           z   COPY public.medico (id_medico, nombre, apellido, especialidad, numero_licencia, telefono, correo_electronico) FROM stdin;
    public               postgres    false    218   :?       �          0    16438    paciente 
   TABLE DATA           �   COPY public.paciente (id_paciente, nombre, documento_identidad, fecha_nacimiento, telefono, correo_electronico, direccion) FROM stdin;
    public               postgres    false    216   �?       �          0    16465    receta 
   TABLE DATA           [   COPY public.receta (id_receta, medicamento, dosis, instrucciones, id_consulta) FROM stdin;
    public               postgres    false    222   �@       �          0    16575    recetas 
   TABLE DATA           \   COPY public.recetas (id_receta, medicamento, dosis, instrucciones, id_consulta) FROM stdin;
    public               postgres    false    226   CA       �          0    16474    usuario 
   TABLE DATA           F   COPY public.usuario (id_usuario, username, password, rol) FROM stdin;
    public               postgres    false    224   �A       �           0    0    consulta_id_consulta_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.consulta_id_consulta_seq', 12, true);
          public               postgres    false    219            �           0    0    medico_id_medico_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.medico_id_medico_seq', 6, true);
          public               postgres    false    217            �           0    0    paciente_id_paciente_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.paciente_id_paciente_seq', 6, true);
          public               postgres    false    215            �           0    0    receta_id_receta_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.receta_id_receta_seq', 4, true);
          public               postgres    false    221            �           0    0    recetas_id_receta_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.recetas_id_receta_seq', 4, true);
          public               postgres    false    225            �           0    0    usuario_id_usuario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 2, true);
          public               postgres    false    223            A           2606    16539    consulta consulta_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (id_consulta);
 @   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_pkey;
       public                 postgres    false    220            =           2606    16536 !   medico medico_numero_licencia_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_numero_licencia_key UNIQUE (numero_licencia);
 K   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_numero_licencia_key;
       public                 postgres    false    218            ?           2606    16522    medico medico_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (id_medico);
 <   ALTER TABLE ONLY public.medico DROP CONSTRAINT medico_pkey;
       public                 postgres    false    218            9           2606    16646 )   paciente paciente_documento_identidad_key 
   CONSTRAINT     s   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_documento_identidad_key UNIQUE (documento_identidad);
 S   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_documento_identidad_key;
       public                 postgres    false    216            ;           2606    16505    paciente paciente_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (id_paciente);
 @   ALTER TABLE ONLY public.paciente DROP CONSTRAINT paciente_pkey;
       public                 postgres    false    216            C           2606    16589    receta receta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.receta
    ADD CONSTRAINT receta_pkey PRIMARY KEY (id_receta);
 <   ALTER TABLE ONLY public.receta DROP CONSTRAINT receta_pkey;
       public                 postgres    false    222            I           2606    16579    recetas recetas_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.recetas
    ADD CONSTRAINT recetas_pkey PRIMARY KEY (id_receta);
 >   ALTER TABLE ONLY public.recetas DROP CONSTRAINT recetas_pkey;
       public                 postgres    false    226            E           2606    16609    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public                 postgres    false    224            G           2606    16481    usuario usuario_username_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_username_key UNIQUE (username);
 F   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_username_key;
       public                 postgres    false    224            J           2606    16551     consulta consulta_id_medico_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_medico_fkey FOREIGN KEY (id_medico) REFERENCES public.medico(id_medico);
 J   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_id_medico_fkey;
       public               postgres    false    218    4671    220            K           2606    16562 "   consulta consulta_id_paciente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES public.paciente(id_paciente);
 L   ALTER TABLE ONLY public.consulta DROP CONSTRAINT consulta_id_paciente_fkey;
       public               postgres    false    220    4667    216            M           2606    16582 #   recetas fkquffl1hpdh7pujx3k0hsga4i1    FK CONSTRAINT     �   ALTER TABLE ONLY public.recetas
    ADD CONSTRAINT fkquffl1hpdh7pujx3k0hsga4i1 FOREIGN KEY (id_consulta) REFERENCES public.consulta(id_consulta);
 M   ALTER TABLE ONLY public.recetas DROP CONSTRAINT fkquffl1hpdh7pujx3k0hsga4i1;
       public               postgres    false    226    220    4673            L           2606    16596    receta receta_id_consulta_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.receta
    ADD CONSTRAINT receta_id_consulta_fkey FOREIGN KEY (id_consulta) REFERENCES public.consulta(id_consulta);
 H   ALTER TABLE ONLY public.receta DROP CONSTRAINT receta_id_consulta_fkey;
       public               postgres    false    4673    222    220            �   �   x�]�AN�0E��)r��4MYtҰ�lٸ��,e������
q��IS$ɋȎ���Fml�m�i��Ӄ��1��jF5��P'�H1�O(^ha�~�0�m��璶p�F��};�}��J��߾�N����	�x����v�b����u����R�!�xv	Ԃ9c�P�_	(FptV�	�<�E��R`
������57���9ɃS��y�~�����1{��L=���lqƄSv�/\�<���&~��R� ��s4      �   �   x�%�A
�0Eד�LƶvW�-x 7CJ$�H���)��������}#�
�@�}?��#=��i8�'@c$���$��76R�!?k�Y��SI���+����b/}{nZ����E��:��.o�i���^05      �   �   x�m��
�0@��W<W�f�ڛ�Mv��%����9���t����</���@�k�j�	q^ù0��.�k얇t����U嬸�9��ar�sQ���5aQX6�QR�]�1Xhe��n8Uا�ӻ-Nؿ��Ռ��N��I�	LpįWr���#[7�7��0s�Ik����(U;���K�� XJ�      �   �   x�u�1�0��+�(	A�4T�i��K����G�!��h�vW����㥤,W�}�`��,�2�d	�x�L��i*�k-�%zK
����(e�����)�]ބ�+����gF�
Ao�p��<V�n�O@=Y��z*&����*c��YB�      �   �   x�����0D��S�(	.X�����M��?92QP0��t������(�k�%�\L��a�s
,0���T�º5�����&��r�IM[{9Fz�x����{���	����aL��\�z[@��N)�HSX�      �      x�3�LL��̃��FƜ�.��~\1z\\\ t�     