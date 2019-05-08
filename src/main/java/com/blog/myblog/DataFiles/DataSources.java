package com.blog.myblog.DataFiles;

import org.springframework.data.repository.CrudRepository;

public interface DataSources extends CrudRepository<DataClass, Long> {
}
