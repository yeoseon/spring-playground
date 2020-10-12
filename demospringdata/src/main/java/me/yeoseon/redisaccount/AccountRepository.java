package me.yeoseon.redisaccount;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, String> {        // 최상위 Repository Interface 중 하나. Redis에 특화된 기능은 아니다.
}
