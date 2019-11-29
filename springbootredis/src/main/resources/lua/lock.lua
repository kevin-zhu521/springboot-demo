IF redis.CALL('setnx', keys[1], argv[1]) == 1 THEN RETURN redis.CALL('expire',
keys[1], argv[2]) ELSE RETURN 0 END 