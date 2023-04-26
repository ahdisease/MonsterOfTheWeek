<template>
  <div>
    <button v-on:click.prevent="showUploadWidget" v-if="!details">Upload Files</button>
    <img v-bind:src="details.secure_url" v-if="details">
  </div>
</template>

<script>
export default {
  name: "cloudinary-image-upload",
  data() {
    return {
      details: ''
    }
  },
  methods: {
    showUploadWidget() {
      return window.cloudinary.openUploadWidget(
        {
          cloud_name: "c19-lima-monster-of-the-week",
          api_key: 965275756759159,
          upload_preset: "unsigned_user",
          sources: ["local", "url"],
          showAdvancedOptions: false,
          cropping: false,
          multiple: false,
          defaultSource: "local",
          styles: {
            palette: {
              window: "#3A5268",
              windowBorder: "#3A5268",
              tabIcon: "#00E88A",
              menuIcons: "#0A8E7B",
              textDark: "#000000",
              textLight: "#FFFFFF",
              link: "#00E88A",
              action: "#007F5F",
              inactiveTabIcon: "#0A8E7B",
              error: "#F44235",
              inProgress: "#00E88A",
              complete: "#007F5F",
              sourceBg: "#E4EBF1",
            },
            fonts: {
              default: null,
              "sans-serif": {
                url: null,
                active: true,
              },
            },
          },
        },
        (err, info) => {
          if (!err) {
            
            if (info.event == 'success') {
              
              this.details = info.info;
              this.$emit('pictureUpload',this.details);
            }
            console.log("Upload Widget event - ", info);
          }
        }
      );
    },
  },
};
</script>
<style scoped>
button {
  background-color:rgb(255, 239, 216)
}
img {

    width: 100%;
   
}
</style>

