<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="监控设备名称" prop="monitoringEquipmentName">
        <el-input
          v-model="queryParams.monitoringEquipmentName"
          placeholder="请输入监控设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监控设备编号" prop="monitoringEquipmentNumber">
        <el-input
          v-model="queryParams.monitoringEquipmentNumber"
          placeholder="请输入监控设备编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['evm:monitoringEquipment:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['evm:monitoringEquipment:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['evm:monitoringEquipment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['evm:monitoringEquipment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="monitoringEquipmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="监控设备ID" align="center" prop="monitoringEquipmentId" v-if="true"/>
      <el-table-column label="监控设备名称" align="center" prop="monitoringEquipmentName" />
      <el-table-column label="监控设备编号" align="center" prop="monitoringEquipmentNumber" />
      <el-table-column label="监控状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['evm:monitoringEquipment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['evm:monitoringEquipment:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改电动车信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="监控设备名称" prop="monitoringEquipmentName">
          <el-input v-model="form.monitoringEquipmentName" placeholder="请输入监控设备名称" />
        </el-form-item>
        <el-form-item label="监控设备编号" prop="monitoringEquipmentNumber">
          <el-input v-model="form.monitoringEquipmentNumber" placeholder="请输入监控设备编号" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMonitoringEquipment, getMonitoringEquipment, delMonitoringEquipment, addMonitoringEquipment, updateMonitoringEquipment } from "@/api/evm/monitoringEquipment";

export default {
  name: "MonitoringEquipment",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 电动车信息表格数据
      monitoringEquipmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        monitoringEquipmentName: undefined,
        monitoringEquipmentNumber: undefined,
        status: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        monitoringEquipmentId: [
          { required: true, message: "监控设备ID不能为空", trigger: "blur" }
        ],
        monitoringEquipmentName: [
          { required: true, message: "监控设备名称不能为空", trigger: "blur" }
        ],
        monitoringEquipmentNumber: [
          { required: true, message: "监控设备编号不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "监控状态不能为空", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询电动车信息列表 */
    getList() {
      this.loading = true;
      listMonitoringEquipment(this.queryParams).then(response => {
        this.monitoringEquipmentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        monitoringEquipmentId: undefined,
        monitoringEquipmentName: undefined,
        monitoringEquipmentNumber: undefined,
        status: "0",
        delFlag: undefined,
        createBy: undefined,
        createTime: undefined,
        updateBy: undefined,
        updateTime: undefined,
        remark: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.monitoringEquipmentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加电动车信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const monitoringEquipmentId = row.monitoringEquipmentId || this.ids
      getMonitoringEquipment(monitoringEquipmentId).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改电动车信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.monitoringEquipmentId != null) {
            updateMonitoringEquipment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addMonitoringEquipment(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const monitoringEquipmentIds = row.monitoringEquipmentId || this.ids;
      this.$modal.confirm('是否确认删除电动车信息编号为"' + monitoringEquipmentIds + '"的数据项？').then(() => {
        this.loading = true;
        return delMonitoringEquipment(monitoringEquipmentIds);
      }).then(() => {
        this.loading = false;
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      }).finally(() => {
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('evm/monitoringEquipment/export', {
        ...this.queryParams
      }, `monitoringEquipment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
