FROM debian:bullseye-slim AS buildtools

# dependencies
RUN apt-get update \
    && apt-get install -y \
                       git \
                       bash \
                       cmake \
                       make \
                       g++ \
                       python3-dev \
                       libatomic-ops-dev \
                       autoconf \
                       libgsl-dev \
                       zlib1g-dev \
                       libzstd-dev \
                       libhts-dev \
                       build-essential \
                       pkg-config \
  && rm -rf /var/lib/apt/lists/*

FROM buildtools AS checkout

# Checkout the two projects
RUN git clone --recursive --single-branch --depth 1 --branch 5.3.0 https://github.com/jemalloc/jemalloc.git
RUN git clone --recursive --single-branch --depth 1 --branch v0.7.2 https://github.com/pangenome/odgi.git

FROM checkout AS build

# Build them statically
ENV CFLAGS "-fpic"
RUN cd /jemalloc && ./autogen.sh && ./configure --prefix=/usr/local --disable-initial-exec-tls --disable-libdl && make build_lib_static && make install_lib_static
RUN cd /odgi && cmake -DBUILD_STATIC=1 -H. -Bbuild && cmake --build build -- -j 3
