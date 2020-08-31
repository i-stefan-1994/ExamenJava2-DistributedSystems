module lib {
    exports lib.rmi;
    exports lib.dto;
    exports lib.model;

    requires transitive java.rmi;
    requires java.persistence;
}