FROM centos:7

RUN yum -y update && \
    yum install -y java-1.8.0-openjdk-devel maven git && \
    yum clean all

WORKDIR /opt/janusgraph
CMD ["analysis/coverity-scan.sh"]
