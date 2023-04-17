<template>
  <div>
    <button v-on:click.prevent="showUploadWidget">Upload Files</button>
  </div>
</template>

<script>
export default {
  name: "cloudinary-image-upload",
  methods: {
    openUploadModal() {
      window.cloudinary.createUploadWidget(
        {
          cloud_name: "c19-lima-monster-of-the-week",
          api_key: 965275756759159,
          upload_preset: "hoigav4j",
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done uploading..: ", result.info);
          }
        }
      );
    },
    showUploadWidget() {
      return window.cloudinary.openUploadWidget(
        {
          cloud_name: "c19-lima-monster-of-the-week",
          api_key: 965275756759159,
          upload_preset: "hoigav4j",
          sources: ["local", "url"],
          showAdvancedOptions: false,
          cropping: true,
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
            console.log("Upload Widget event - ", info);
          }
        }
      );
    },
    // created() {
    //   const cloudinary = Document.createElement("script");
    //   cloudinary.setAttribute(
    //     "src",
    //     "https://widget.cloudinary.com/v2.0/global/all.js"
    //   );
    //   cloudinary.setAttribute("type", "text/javascript");
    //   event.currentTarget.paretnElement.appendChild(cloudinary);
    // },
  },
};
</script>

<style scoped>
iframe {
  display: relative;
}
</style>
