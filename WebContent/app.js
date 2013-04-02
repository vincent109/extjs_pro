
Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    models: [
        'Company'
    ],
    stores: [
        'Companies'
    ],
    views: [
        'CompanyGrid',
        'AppViewport'
    ],
    autoCreateViewport: true,
    name: 'Sencha',
    controllers: [
        'Company'
    ]
});
