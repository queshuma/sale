sale项目介绍
    1.接口详情
        用户接口
            登陆接口(UserLogin)：通过邮箱/手机号，密码进行校验，同时生成token校验码，将校验吗注入浏览器的cookie和服务器的redis
            注册接口(UserRegister):通过邮箱、手机号、用户昵称同时进行校验，若无相同用户数据，则进行用户注册
            修改接口(UserModify)：通过cookie获取用户昵称，通过前端提供的数据，进行数据覆盖，更新用户数据 
            信息接口(UserInfo):通过cookie获取用户昵称，通过用户昵称检索用户信息，输出用户可见的信息
        商品接口
            信息接口(ProductsList):检索所有商品详情
            添加接口(ProductsAdd):添加商品信息，自动增加产品id
            更新接口(ProductUpdate):更新商品信息，根据商品的name(商品name为不可变属性)
            搜索接口(ProductSearch):根据产品名称进行搜索产品，以列表的形式呈现
            分类接口(ProductTag):根据产品的分类进行检索