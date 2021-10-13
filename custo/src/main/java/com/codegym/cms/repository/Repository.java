<<<<<<< HEAD


package com.codegym.cms.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
=======


package com.codegym.cms.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
>>>>>>> 5f51a86c18aa2e8cb69ea8806d890c307b27259d
