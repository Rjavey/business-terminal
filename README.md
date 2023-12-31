### TODO

~~需补充物料上下级关系表~~ ~~供应商物料关系表~~
~~优先完成用户身份信息获取，避免后期大量修改代码获取身份id~~
~~物料产品父子级关系表需补充~~
生产计划管理开发（ 生产计划日志采用事件模式）
生产计划增加对应订单id（改为多对多表关联）
生产计划表缺失状态字段
修改删除为支持批量删除

### 待开发功能

一阶段

1. [x] 供应商管理 增删改查
2. [x] 物料（产品）管理 （产品分类管理 增删改查 产品管理增删改查）
3. [ ] 成本管理 （产品成本配置）
4. [ ] 订单管理 （历史订单成本查看 订单一键生成材料目录 订单生产进度查看）
5. [ ] 客户管理
6. [ ] 生产管理
7. [ ] 审批流程管理 审批流程创建、流转
8. [ ] 人员管理
9. [ ] 权限管理（提供默认的3种权限配置）
10. [ ] 仓储管理 （仓库管理增删改查 物料入库出库）

二阶段

11. 物流管理
12. 财务管理
13. 行政管理
14. 生产报表

### 功能详细

1. 供应商管理

| 序号 |  功能   |        说明        | 状态  |
|:--:|:-----:|:----------------:|:---:|
| 1  | 添加供应商 |    添加外购或外协供应商    | 待测试 |
| 2  | 修改供应商 |    修改外购或外协供应商    | 待测试 |
| 3  | 查询供应商 | 查询外购或外协供应商（分页查询） | 待测试 |
| 4  | 删除供应商 | 删除外购或外协供应商（软删除）  | 待测试 |

2. 物料管理

| 序号 |  功能  |           说明            | 状态  |
|:--:|:----:|:-----------------------:|:---:|
| 1  | 添加物料 | 添加产品物料（包括原材料/半成品/外协/成品） | 待测试 |
| 2  | 修改物料 |         修改物料信息          | 待测试 |
| 3  | 查询物料 |       查询物料信息（分页）        | 待测试 |
| 4  | 删除物料 |        删除物料（软删除）        | 待测试 |

3. 成本管理

| 序号 |   功能   |             说明              | 状态  |
|:--:|:------:|:---------------------------:|:---:|
| 1  | 添加物料成本 | 添加产品物料（包括原材料/半成品/外协/成品）成本信息 | 未完成 |
| 2  | 修改物料成本 |          修改物料成本信息           | 未完成 |
| 3  | 查询物料成本 |   查询物料成本信息（分页通过物料关联成本查询）    | 未完成 |

4. 订单管理

| 序号 |    功能    |             说明              | 状态  |
|:--:|:--------:|:---------------------------:|:---:|
| 1  |  添加销售订单  | 添加产品物料（包括原材料/半成品/外协/成品）成本信息 | 未完成 |
| 2  |  查询销售订单  |       查询销售订单信息（分页查询）        | 未完成 |
| 3  | 查询销售订单详情 |  查询销售订单详细信息（包括历史成本 供应商信息等）  | 未完成 |

5. 客户管理

| 序号 |    功能    |             说明              | 状态  |
|:--:|:--------:|:---------------------------:|:---:|
| 1  |   添加客户   | 添加产品物料（包括原材料/半成品/外协/成品）成本信息 | 未完成 |
| 2  |   查询客户   |        查询客户信息（分页查询）         | 未完成 |
| 3  | 查询客户详细信息 |     查询客户详细信息（包括累计订单数量等）     | 未完成 |
| 4  |   编辑客户   |  编辑客户信息（包括删除-删除为设置客户当前类型）   | 未完成 |

6. 生产管理

| 序号 |      功能      |            说明            | 状态  |
|:--:|:------------:|:------------------------:|:---:|
| 1  |    添加生产计划    |  添加生产计划（通过前端分解产品创建子任务）   | 未完成 |
| 2  |    查询生产计划    |       查询客户信息（分页查询）       | 未完成 |
| 3  |    编辑生产计划    | 编辑客户信息（包括删除-删除为设置客户当前类型） | 未完成 |
| 4  |   查询生产计划日志   |  通过生产计划的进度及编辑展示当前计划的变动   | 未完成 |
| 5  | 库存比对（等待库存完成） |         比对当前仓库库存         | 未完成 |

7. 审批流程管理

| 序号 |   功能   |        说明        | 状态  |
|:--:|:------:|:----------------:|:---:|
| 1  | 添加审批流程 |     创建业务审批流程     | 未完成 |
| 2  | 查询审批流程 |     查询业务审批流程     | 未完成 |
| 3  | 修改审批流程 |     修改业务审批流程     | 未完成 |
| 4  | 删除审批流程 |  删除业务审批流程（软删除）   | 未完成 |
| 5  | 设置审批流程 |   对生产业务增加审批流程    | 未完成 |
| 6  | 审批流程流转 | 更新业务配置的审批流程状态及信息 | 未完成 |

8. 人员管理

| 序号 |   功能   |        说明         | 状态  |
|:--:|:------:|:-----------------:|:---:|
| 1  | 添加租户人员 | 创建租户公司新账号（手机号或短信） | 未完成 |
| 2  | 查询人员信息 |      查询租户内人员      | 未完成 |
| 3  | 修改人员信息 |     修改租户人员信息      | 未完成 |
| 4  |  删除人员  |   删除租户内人员（软删除）    | 未完成 |

9. 权限管理

| 序号 |  功能  |       说明       | 状态  |
|:--:|:----:|:--------------:|:---:|
| 1  | 添加角色 |     添加新角色      | 未完成 |
| 2  | 查询角色 |     查询租户角色     | 未完成 |
| 3  | 修改角色 |     修改租户角色     | 未完成 |
| 4  | 删除角色 | 删除角色（软删除 shan） | 未完成 |