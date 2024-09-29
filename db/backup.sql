--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: code_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.code_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.code_seq OWNER TO postgres;

--
-- Name: code_seq_2; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.code_seq_2
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.code_seq_2 OWNER TO postgres;

--
-- Name: code_seq_3; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.code_seq_3
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.code_seq_3 OWNER TO postgres;

--
-- Name: code_seq_4; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.code_seq_4
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.code_seq_4 OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
    pr_id integer DEFAULT nextval('public.code_seq_2'::regclass) NOT NULL,
    pr_name text NOT NULL,
    description text NOT NULL,
    p_progress integer NOT NULL,
    team_id integer NOT NULL,
    p_begin date NOT NULL,
    p_end date NOT NULL
);


ALTER TABLE public.project OWNER TO postgres;

--
-- Name: subtasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.subtasks (
    sub_id integer DEFAULT nextval('public.code_seq_3'::regclass) NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    status boolean NOT NULL,
    begin date NOT NULL,
    "end" date NOT NULL,
    exe_id integer NOT NULL,
    t_id integer NOT NULL
);


ALTER TABLE public.subtasks OWNER TO postgres;

--
-- Name: tasks; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tasks (
    t_id integer DEFAULT nextval('public.code_seq_4'::regclass) NOT NULL,
    t_name text NOT NULL,
    description text NOT NULL,
    t_progress integer NOT NULL,
    begin date NOT NULL,
    "end" date NOT NULL,
    pr_id integer NOT NULL
);


ALTER TABLE public.tasks OWNER TO postgres;

--
-- Name: team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.team (
    team_id integer DEFAULT nextval('public.code_seq'::regclass) NOT NULL,
    t_name text NOT NULL,
    lead_id integer NOT NULL
);


ALTER TABLE public.team OWNER TO postgres;

--
-- Name: user_team; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_team (
    user_id integer NOT NULL,
    team_id integer NOT NULL
);


ALTER TABLE public.user_team OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id integer NOT NULL,
    login text NOT NULL,
    password text NOT NULL,
    email text NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project (pr_id, pr_name, description, p_progress, team_id, p_begin, p_end) FROM stdin;
1	efrgr	fgrethtym,	50	1	2010-10-10	2020-10-20
2	po;uilkk	xvcbmn,gtgfr4578	0	1	2010-10-10	2020-10-20
\.


--
-- Data for Name: subtasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.subtasks (sub_id, name, description, status, begin, "end", exe_id, t_id) FROM stdin;
1	ertuk	weqaefwef3w4t	t	2012-12-12	2014-09-14	1	2
2	segr7689[pi	sdfwerwe	f	2012-12-12	2014-09-14	2	2
\.


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tasks (t_id, t_name, description, t_progress, begin, "end", pr_id) FROM stdin;
1	fgbgfnrtyh	gfhfhmggh	5	2001-01-01	2002-02-02	1
2	09876543	765432	90	2012-12-12	2002-02-02	1
\.


--
-- Data for Name: team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.team (team_id, t_name, lead_id) FROM stdin;
1	cool_team	1
3	cool_team	1
4	cool_team	1
6	cool_team	1
7	cool_team	1
8	cool_team	1
9	cool_team	1
10	cool_team	1
11	cool_team	1
12	cool_team	1
\.


--
-- Data for Name: user_team; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_team (user_id, team_id) FROM stdin;
1	1
1	3
1	4
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, login, password, email) FROM stdin;
2	[poiuhj	erws	56ujuyjh@gmail.com
3	1	1	1
1	qwerty	wert	ergerge@mail.ru
\.


--
-- Name: code_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.code_seq', 12, true);


--
-- Name: code_seq_2; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.code_seq_2', 1, false);


--
-- Name: code_seq_3; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.code_seq_3', 1, false);


--
-- Name: code_seq_4; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.code_seq_4', 1, false);


--
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (pr_id);


--
-- Name: subtasks subtasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtasks
    ADD CONSTRAINT subtasks_pkey PRIMARY KEY (sub_id);


--
-- Name: tasks tasks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (t_id);


--
-- Name: team team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT team_pkey PRIMARY KEY (team_id);


--
-- Name: users user_inf_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_inf_pkey PRIMARY KEY (user_id);


--
-- Name: user_team user_team_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_team
    ADD CONSTRAINT user_team_pkey PRIMARY KEY (user_id, team_id);


--
-- Name: tasks fk_project; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fk_project FOREIGN KEY (pr_id) REFERENCES public.project(pr_id) NOT VALID;


--
-- Name: tasks fk_tasks; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT fk_tasks FOREIGN KEY (t_id) REFERENCES public.tasks(t_id) NOT VALID;


--
-- Name: user_team fk_team; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_team
    ADD CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES public.team(team_id) NOT VALID;


--
-- Name: project fk_team; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT fk_team FOREIGN KEY (team_id) REFERENCES public.team(team_id) NOT VALID;


--
-- Name: user_team fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_team
    ADD CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES public.users(user_id) NOT VALID;


--
-- Name: subtasks pk_tasks; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtasks
    ADD CONSTRAINT pk_tasks FOREIGN KEY (t_id) REFERENCES public.tasks(t_id) NOT VALID;


--
-- Name: subtasks pk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.subtasks
    ADD CONSTRAINT pk_users FOREIGN KEY (exe_id) REFERENCES public.users(user_id) NOT VALID;


--
-- Name: team pk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.team
    ADD CONSTRAINT pk_users FOREIGN KEY (lead_id) REFERENCES public.users(user_id) NOT VALID;


--
-- PostgreSQL database dump complete
--

