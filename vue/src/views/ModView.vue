<template>
  <div>
    <user-list />
    <unapproved-image-list/>
  </div>
</template>

<script>
import UserList from '../components/UserList.vue'
import UnapprovedImageList from '../components/UnapprovedImageList.vue'

export default {
    components: {
        UserList,
        UnapprovedImageList
    }
     
}
</script>

<style>

</style>