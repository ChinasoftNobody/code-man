package com.chinasoft.lgh.codeman.server.repo;

import com.chinasoft.lgh.codeman.server.model.MUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.regex.Pattern;

@Repository
public class UserDao {
    @Resource
    private MongoTemplate mongoTemplate;

    public Page<MUser> findByKeyword(String keyword, Pageable pageable) {
        String key = "";
        if (!StringUtils.isEmpty(keyword)) {
            key = keyword;
        }
        Pattern pattern = Pattern.compile("^.*" + key + ".*$", Pattern.CASE_INSENSITIVE);
        Criteria where = Criteria.where("deleted").is(false).orOperator(Criteria.where("name").regex(pattern),
                Criteria.where("email").regex(pattern),
                Criteria.where("phone").regex(pattern));
        long count = mongoTemplate.count(Query.query(where), MUser.class);
        if (count > 0) {
            // 分页从零开始
            long skip = (pageable.getPageNumber()) * pageable.getPageSize();
            long limit = pageable.getPageSize();
            Aggregation aggregation;
            if (pageable.getSort().isSorted()) {
                aggregation = Aggregation.newAggregation(
                        Aggregation.match(where),
                        Aggregation.sort(pageable.getSort()),
                        Aggregation.skip(skip),
                        Aggregation.limit(limit));
            } else {
                aggregation = Aggregation.newAggregation(
                        Aggregation.match(where),
                        Aggregation.skip(skip),
                        Aggregation.limit(limit));
            }
            AggregationResults<MUser> aggregate = mongoTemplate.aggregate(aggregation, MUser.class, MUser.class);
            return new PageImpl<>(aggregate.getMappedResults(), pageable, count);
        }
        return new PageImpl<>(Collections.emptyList(), pageable, count);
    }
}
