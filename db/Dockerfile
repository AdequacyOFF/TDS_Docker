FROM postgres:17
COPY backup.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
ENV POSTGRES_DB=tds_project
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
HEALTHCHECK --interval=10s --timeout=5s --start-period=10s --retries=3 \
  CMD pg_isready -U ${POSTGRES_USER} -d ${POSTGRES_DB} || exit 1