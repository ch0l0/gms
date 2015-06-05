package com.leo.gms.service.util

import com.leo.gms.service.common.BaseService

class SystemSettingsService extends BaseService{
    def grailsApplication

    int getDefaultPageSize(){
        return grailsApplication.config.app.gms.pagination.pageSize
    }

}
