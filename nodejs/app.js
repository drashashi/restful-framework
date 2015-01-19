var test = Lawnchair(function() {

        // setup some callbacks
        //     this.before('save', 'console.log("about to save " + record.name)')
        //         this.after('save', 'console.log(record.name + " has been saved")')
        //
        //             this.save({name:'brian'})
        //                 // about to save brian
        //                     // brian has been saved
})

test.save({key: 1, value: "testing"});

test.all(function(data){
    console.log(data)
})

test.get(2, function(data){
    console.log(data.value);
})


