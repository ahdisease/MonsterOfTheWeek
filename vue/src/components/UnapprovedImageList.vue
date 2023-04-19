<template>
  <div id='image-table'>
    <div class="divTable userTable">
      <div class="divTableHeading">
        <div class="divTableRow">
          <div class="divTableHead">Image</div>
          
          <div class="divTableHead">Ban User</div>
        </div>
      </div>
      <div class="divTableBody">
        <div class="divTableRow" v-for="image in imageList" v-bind:key="image.id">
          <div class="divTableCell"> <img :src="[image.url ? image.url : '#']" alt="Image failed to load"> </div>
          
          <div class="divTableCell">
              <button id="approve-btn" v-show="!image.approved"
              v-on:click.prevent="approveImage(image.id)">Approve Image</button>
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
      imageList: [],
    };
  },
  methods: {
      approveImage(id) {
          ModService.approveImageById(id).then(() => {
              this.updateImageList();
          })
      },
      updateImageList() {
          ModService.getUnapprovedImages().then((response) => {
      this.imageList = response.data;
    });
      }
  },
  created() {
    this.updateImageList();
  },
};
</script>

<style scoped>
#image-table {
  background-color: #5e7386;
  margin: 10px 0;
}

img {
  height: 280px;
  width: 190px;
  object-fit: fill;
}

#approve-btn{
  background-color: lightgray;
}

div.userTable {
  background-color: #00201e;
  width: 90%;
  text-align: center;
  margin: 0 auto;
  border-collapse: collapse;
}
.divTable.userTable .divTableCell,
.divTable.userTable .divTableHead {
  padding: 3px 2px;
}
.divTable.userTable .divTableBody .divTableCell {
  font-size: 13px;
}
.divTable.userTable .divTableRow:nth-child(even) {
  background: #3a5268;
}

.divTable.userTable .divTableHeading {
  background: #00201e;
  background: -moz-linear-gradient(top, #017069 0%, #01423e 66%, #00201e 100%) ;
  background: -webkit-linear-gradient(
    top,
    #017069 0%,
    #01423e 66%,
    #00201e 100%
  );
  background: linear-gradient(to bottom, #00201e 0%, #01423e 66%, #017069 100%);
}
.divTable.userTable .divTableHeading .divTableHead {
  font-size: 18px;
  font-weight: bold;
  color: goldenrod;
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