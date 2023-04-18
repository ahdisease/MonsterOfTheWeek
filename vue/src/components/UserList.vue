<template>
  <div id="user-table">
    <div class="divTable userTable">
      <div class="divTableHeading">
        <div class="divTableRow">
          <div class="divTableHead">Username</div>
          <div class="divTableHead">User Role</div>
          <div class="divTableHead">Ban User</div>
        </div>
      </div>
      <div class="divTableBody">
        <div class="divTableRow" v-for="user in userList" v-bind:key="user.id">
          <div class="divTableCell">{{ user.username }}</div>
          <div class="divTableCell">{{ user.authorities[0].name }}</div>
          <div class="divTableCell">
              <button id="ban-btn" v-show="user.authorities[0].name!='ROLE_BAN'"
              v-on:click.prevent="banUser(user.id)">Ban User</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ModService from "../services/ModService";
export default {
  name: "user-list",
  data() {
    return {
      userList: [],
    };
  },
  methods: {
      banUser(id) {
          ModService.banUserById(id).then(() => {
              this.updateUserList();
          })
      },
      updateUserList() {
          ModService.getAllUsers().then((response) => {
      this.userList = response.data;
    });
      }
  },
  created() {
    this.updateUserList();
  },
};
</script>

<style scoped>
#user-table{
  background-color: #00201e;
}
#ban-btn{ 
  background-color: lightgreen;
}
div.userTable {
  border: 1px solid goldenrod;
  background-color: #7a9bb9;
  width: 90%;
  text-align: left;
  margin: 0 auto;
  border-collapse: collapse;
}
.divTable.userTable .divTableCell,
.divTable.userTable .divTableHead {
  border: 1px solid goldenrod;
  padding: 3px 2px;
}
.divTable.userTable .divTableBody .divTableCell {
  font-size: 13px;
}
.divTable.userTable .divTableRow:nth-child(even) {
  background: #d0e4f5;
}
.divTable.userTable .divTableHeading {
  background: #1c6ea4;
  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1c6ea4 100%);
  background: -webkit-linear-gradient(
    top,
    #5592bb 0%,
    #327cad 66%,
    #1c6ea4 100%
  );
  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1c6ea4 100%);
  border-bottom: 2px solid goldenrod;
}
.divTable.userTable .divTableHeading .divTableHead {
  font-size: 15px;
  font-weight: bold;
  color: #00E88A;
  border-left: 2px solid goldenrod;
}
.divTable.userTable .divTableHeading .divTableHead:first-child {
  border-left: none;
}
.userTable .tableFootStyle {
  font-size: 14px;
  font-weight: bold;
  color: #ffffff;
  background: #d0e4f5;
  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #d0e4f5 100%);
  
  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #d0e4f5 100%);
  border-top: 2px solid #444444;
}
.userTable .tableFootStyle {
  font-size: 14px;
}
.userTable .tableFootStyle .links {
  text-align: right;
}
.userTable .tableFootStyle .links a {
  display: inline-block;
  background: #1c6ea4;
  color: #ffffff;
  padding: 2px 8px;
  border-radius: 5px;
}
.userTable.outerTableFooter {
  border-top: none;
}
.userTable.outerTableFooter .tableFootStyle {
  padding: 3px 5px;
}
/* DivTable.com */
.divTable {
  display: table;
}
.divTableRow {
  display: table-row;
}
.divTableHeading {
  display: table-header-group;
}
.divTableCell,
.divTableHead {
  display: table-cell;
}
.divTableHeading {
  display: table-header-group;
}
.divTableFoot {
  display: table-footer-group;
}
.divTableBody {
  display: table-row-group;
}
</style>