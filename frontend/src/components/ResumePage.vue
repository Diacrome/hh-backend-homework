<template>
  <div class="app-container">
    <el-row>
      <el-col>
        <!--<el-button-group>-->
        <el-button @click="onCreateUserButtonClick" type="success">
          Создать пользователя
        </el-button>
        <el-button @click="onCreateResumeButtonClick" type="success">
          Создать резюме
        </el-button>
        <el-button @click="onCreateCompanyButtonClick" type="success">
          Создать компанию
        </el-button>
        <el-button @click="onCreateVacancyButtonClick" type="success">
          Создать вакансию
        </el-button>
        <!--</el-button-group>-->
      </el-col>
    </el-row>
    <el-row :class="'content'">
      <el-tabs v-model="activeName">
        <el-tab-pane label="Вакансии" name="vacancies">
          <el-table
            :data="vacancies"
            style="width: 100%">
            <el-table-column
              width="220px"
              label="Заголовок"
              prop="title">
            </el-table-column>
            <el-table-column
              label="Компания"
              prop="company.name">
            </el-table-column>
            <el-table-column
              width="125px"
              label="Дата создания"
              prop="dateCreate">
            </el-table-column>
            <el-table-column width="300px"
                             align="right">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="openVacancyPopup(scope.row.id)">Подробнее
                </el-button>
                <el-button
                  @click="onCreateNegotiationButtonClick(scope.row.id)"
                  size="mini"
                >Добавить отклик
                </el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="Резюме" name="resume">
          <el-table
            :data="resumes"
            style="width: 100%">
            <el-table-column
              width="220px"
              label="Заголовок"
              prop="title">
            </el-table-column>
            <el-table-column
              label="Имя"
              prop="applicant.name">
            </el-table-column>
            <el-table-column
              width="125px"
              label="Дата создания"
              prop="dateCreate">
            </el-table-column>
            <el-table-column width="300px"
                             align="right">
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>
    </el-row>
    <create-user-form ref="createUserForm"/>
    <create-resume-form ref="createResumeForm"/>
    <create-company-form ref="createCompanyForm"/>
    <create-vacancy-form ref="createVacancyForm"/>
    <vacancy-data-popup ref="vacancyDataPopup"/>
    <create-negotiation-form ref="createNegotiationForm"/>
  </div>
</template>

<script>
  import CreateUserForm from './CreateUserForm'
  import CreateResumeForm from './CreateResumeForm'
  import CreateCompanyForm from './CreateCompanyForm'
  import CreateVacancyForm from './CreateVacancyForm'
  import VacancyDataPopup from './VacancyDataPopup'
  import CreateNegotiationForm from './CreateNegotiationForm'

  import { getVacancies } from './../api/vacancy'
  import { getResumes } from '../api/resume'

  export default {
    name: 'ResumePage',
    components: {
      CreateNegotiationForm,
      CreateUserForm,
      CreateResumeForm,
      CreateCompanyForm,
      CreateVacancyForm,
      VacancyDataPopup
    },
    mounted () {
      this.loadVacancies()
      this.loadResumes()
    },
    data () {
      return {
        activeName: 'vacancies',
        vacancies: [],
        resumes: []
      }
    },
    methods: {
      openVacancyPopup (vacancyId) {
        this.$refs['vacancyDataPopup'].open(vacancyId)
      },
      onCreateUserButtonClick () {
        this.$refs['createUserForm'].open()
      },
      onCreateResumeButtonClick () {
        this.$refs['createResumeForm'].open()
      },
      onCreateCompanyButtonClick () {
        this.$refs['createCompanyForm'].open()
      },
      onCreateVacancyButtonClick () {
        this.$refs['createVacancyForm'].open()
      },
      onCreateNegotiationButtonClick (vacancyId) {
        this.$refs['createNegotiationForm'].open(vacancyId)
      },
      loadVacancies () {
        getVacancies()
          .then(response => {
            this.vacancies = response.data
          })
      },
      loadResumes () {
        getResumes()
          .then(response => {
            this.resumes = response.data
          })
      }
    },
  }
</script>

<style scoped>
  .app-container {
    max-width: 800px;
    margin: 0 auto;
  }

  .content {
    margin-top: 45px;
  }
</style>
