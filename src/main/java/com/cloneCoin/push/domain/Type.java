package com.cloneCoin.push.domain;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Type {
    BOUGHT,
    SOLD,
    LEADEROUT,
    COPYSTART,
    FOLLOWSTART,
    FOLLOWEND,
    @JsonEnumDefaultValue UNKNOWN
}
