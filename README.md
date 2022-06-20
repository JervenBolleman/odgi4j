# odgi4j
libodgi bindings for java


Aim to be able to access odgi files without any hassle from java.

# Building Odgi with jemalloc that is dynamically loadable

```
cd buildOdgiForJNI/
podman build .
# note the image hash in my case b13969596ce1
podman run -it b13969596ce1
# in a second terminal
podman container list
# use the container id in my case b13969596ce1
podman cp 372718eff1f1:/odgi/lib/libodgi.so ../src/main/resources/linux/amd64/libodgi.so
# then kill the container again.
```
