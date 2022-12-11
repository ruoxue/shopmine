数据表
    宗教类型 religion_type (佛 道 。。。)
    宗教场所 religion_area  (某个地方的教会，如门店一样，这个场所要有许可证，如果一个地方多个许可证，可用-1 -2区分，)
    宗教人员 宗教团体 religion_user (必须有挂靠场所下，如果没有被挂靠，则为异常人员，对宗教人员进行核教宗进行简单角色区分，与后台管理区分开来，宗教类别、宗教派别、所属区域、具体地址、姓名、性别、民族、法名、职别、联系方式、毕业院校、受教育程度等信息。)
    
    视频数据 religion_video (宗教视频，实时拉起，)
    工单     religion_work  （工单，是否可配置，如果需要配置，要引入工作流系统，配置后工单流转如请假）
    宗教建筑库 religion_Building (宗教的外部环境表，省市县区，+详细地址)
    民族 religion_nation  （基础信息，可扩张）
    
    民间烧香点 religion_sacrifice（划定制定区域，类比美团的特定停车点）
    
    财务数据，religion_finance （月 季 半年  年，是否需要提供资金流，对各个场所进行资金监控，此处为独立模块，）
    财务投诉 religion_finance_complain  （为记录表，包含 投诉对象，如果需要与投诉者进行交流，需建子表关联）
    
    非法宗教活动管理，涉外宗教活动管理 religion_activity_complain （信息登记、现场处置音视频记录）
    
    场所建设登记管理 religion_build_manager 建设的项目
    
    涉违规用地登记备案  religion_error_manager  违规登记，自查
    
    法事、法会、牌位登记备案 religion_party_manager 集会登记 （人数 地点。。。）
    
    重大活动备案   religion_activty_manager 
    
    临时人员 指向user
    临时人员记录    religion_outuser_manager 登记审核
    清真食品备案    religion_halal_manager 
    行政许可备案    religion_gov_manager  如果备案成功，对团体进行标识
    行政诉讼、行政复议登记  religion_gov_lawsuit  展示表
    文明和谐寺观教堂创建,民族团结进步创建  religion_harmonious_build
    宗教场所安全监管  religion_safety  对地点进行记录
    场所消防安全管理  religion_safety_manager   安全管理登记，自查上报
    消防责任人 指向user
    消防演练管理  religion_drill_manager 上报或后台添加
    消防预警接入  religion_warn_manager
    
    建筑安全隐患排查   religion_build_safe_manager
    建筑隐患信息上报  religion_buildsafe_info_manager
    全区建筑隐患统计  对上表进行统计

    疫情防控检查  religion_epidemic_control 场所自行登记
    场所消杀管理 religion_disinfection_control 场所自行登记
    
    场所突发应急管理   religion_emergency_type  突发灾害事件、突发治安事件、人员聚集事件等
    突发事件记录  religion_emergency_record 记录
    应急预案管理   religion_emergency_manager

    视频信息接入 参照 religion_video 进行拉取 可能使用腾讯云推流 或者rtmp之类

    异常聚集管理   religion_error_manager  
    

    非法宗教活动信息   religion_illegal_manager 
    骨干人员信息管理  指向对user 黑名单
    重点人员库   黄名单
    照片采集 质量筛选 user

    预警   religion_message 消息提醒
    
    

    宗教app  使用uniapp
        通知公告  religion_message 表
        信息登记
        日常检查
        学习辅助  religion_learn   学习的视频等
        宗教地图   百度地图打桩
        宗教场所   百度地图打桩介绍
        政策法规
        动态信息
        文化学习
        便民服务
        举报投诉
        评价投诉

    智能化数据平台后台支撑
       
        用户管理
        机构管理
        角色管理
        权限管理
        日志管理
        系统备份管理 sh脚本执行
        
    
    
    


    
    
    